<?php

namespace AppBundle\Controller;

use AppBundle\Entity\Film;
use AppBundle\Form\FilmType;
use Sensio\Bundle\FrameworkExtraBundle\Configuration\Route;
use Symfony\Bundle\FrameworkBundle\Controller\Controller;
use Symfony\Component\HttpFoundation\Request;

class FilmController extends Controller
{
    /**
     * @param Request $request
     * @Route("/", name="index")
     * @return \Symfony\Component\HttpFoundation\Response
     */
    public function index(Request $request)
    {
        // Get all films
        $films = $this->getDoctrine()->getRepository(Film::class)->findAll();

        // Pass the films to the index view
        return $this->render('film/index.html.twig',['films' => $films]);
    }

    /**
     * @param Request $request
     * @Route("/create", name="create")
     * @return \Symfony\Component\HttpFoundation\Response
     */
    public function create(Request $request)
    {
        // Create a new film object
        $film = new Film();

        // Pass the empty film object to the form
        $form = $this->createForm(FilmType::class, $film);
        $form->handleRequest($request);

        $errorMsg = "";

        // If the form is submitted and is valid, save the film in the database
        if ($form->isSubmitted()){
            if ($form->isValid()){
                $em = $this->getDoctrine()->getManager();
                $em->persist($film);
                $em->flush();

                return $this->redirectToRoute('index');
            } else {
                $errorMsg = "Invalid form data";
            }
        }

        // If there is an error, show the create form again
        return $this->render('film/create.html.twig',
            ["film" => $film, "form" => $form->createView(),
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
        // Get the film to be edited
        $film = $this->getDoctrine()->getRepository(Film::class)->find($id);
        if ($film == null){
            return $this->redirect("/");
        }

        // Pass the film to be edited to the edit form
        $form = $this->createForm(FilmType::class, $film);
        $form->handleRequest($request);

        $errorMsg = "";

        // If the form is submitted and is valid, edit the film in the database
        if ($form->isSubmitted()){
            if ($form->isValid()){
                $em = $this->getDoctrine()->getManager();
                $em->merge($film);
                $em->flush();

                return $this->redirectToRoute('index');
            } else {
                $errorMsg = "Invalid form data";
            }
        }

        // If there is an error, show the edit form again
        return $this->render('film/edit.html.twig',
            ["film" => $film, "form" => $form->createView(),
                "errorMsq" => $errorMsg]
        );
    }

    /**
     * @Route("/delete/{id}", name="delete")
     *
     * @param $id
     * @param Request $request
     * @return \Symfony\Component\HttpFoundation\Response
     */
    public function delete($id, Request $request)
    {
        // Get the film to be deleted
        $film = $this->getDoctrine()->getRepository(Film::class)->find($id);
        if ($film == null){
            return $this->redirect("/");
        }

        // Pass the film to be deleted to the delete form
        $form = $this->createForm(FilmType::class, $film);
        $form->handleRequest($request);

        // If the form is submitted and is valid, delete the film from the database
        if ($form->isSubmitted()){
            if ($form->isValid()){
                $em = $this->getDoctrine()->getManager();
                $em->remove($film);
                $em->flush();

                return $this->redirectToRoute('index');
            }
        }

        // If there is an error, show the delete form again
        return $this->render('film/delete.html.twig',
            ["film" => $film, "form" => $form->createView()]
        );
    }
}
