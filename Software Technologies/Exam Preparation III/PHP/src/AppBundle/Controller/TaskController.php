<?php

namespace AppBundle\Controller;

use AppBundle\Entity\Task;
use AppBundle\Form\TaskType;
use Sensio\Bundle\FrameworkExtraBundle\Configuration\Route;
use Symfony\Bundle\FrameworkBundle\Controller\Controller;
use Symfony\Component\HttpFoundation\Request;

class TaskController extends Controller
{
    /**
     * @param Request $request
     * @Route("/", name="index")
     * @return \Symfony\Component\HttpFoundation\Response
     */
    public function index(Request $request)
    {
       // Get all open tasks
        $openTasks = $this->getDoctrine()->getRepository(Task::class)->findBy(['status'=> 'Open']);
        $inProgressTasks = $this->getDoctrine()->getRepository(Task::class)->findBy(['status'=> 'In Progress']);
        $finishedTasks = $this->getDoctrine()->getRepository(Task::class)->findBy(['status'=> 'Finished']);

        // Pass the tasks to the index view
        return $this->render('task/index.html.twig',
                ['openTasks' => $openTasks,
                'inProgressTasks' => $inProgressTasks,
                'finishedTasks' => $finishedTasks]);
    }

    /**
     * @param Request $request
     * @Route("/create", name="create")
     * @return \Symfony\Component\HttpFoundation\Response
     */
    public function create(Request $request)
    {
        // Create a new task object
        $task = new Task();

        // Pass the empty task object to the form
        $form = $this->createForm(TaskType::class, $task);
        $form->handleRequest($request);

        $errorMsg = "";

        // If the form is submitted and is valid, save the task in the database
        if ($form->isSubmitted()){
            if ($form->isValid()){
                $em = $this->getDoctrine()->getManager();
                $em->persist($task);
                $em->flush();

                return $this->redirectToRoute('index');
            } else {
                $errorMsg = "Invalid form data";
            }
        }

        // If there is an error, show the create form again
        return $this->render('task/create.html.twig',
            ["task" => $task, "form" => $form->createView(),
                "errorMsq" => $errorMsg]
        );
    }

    /**
     * @Route("/edit/{id}", name="edit")
     *
     * @param $id
     * @param Request $request
     * @return \Symfony\Component\HttpFoundation\Response
     */
    public function edit($id, Request $request)
    {
        // Get the task to be edited
        $task = $this->getDoctrine()->getRepository(Task::class)->find($id);
        if ($task == null){
            return $this->redirect("/");
        }

        // Pass the task to be edited to the form
        $form = $this->createForm(TaskType::class, $task);
        $form->handleRequest($request);

        $errorMsg = "";

        // If the form is submitted and is valid, edit the task in the database
        if ($form->isSubmitted()){
            if ($form->isValid()){
                $em = $this->getDoctrine()->getManager();
                $em->merge($task);
                $em->flush();

                return $this->redirectToRoute('index');
            } else {
                $errorMsg = "Invalid form data";
            }
        }

        // If there is an error, show the create form again
        return $this->render('task/edit.html.twig',
            ["task" => $task, "form" => $form->createView(),
                "errorMsq" => $errorMsg]
        );
    }
}
