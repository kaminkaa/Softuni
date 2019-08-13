<?php

namespace AppBundle\Controller;

use AppBundle\Entity\Report;
use AppBundle\Form\ReportType;
use Sensio\Bundle\FrameworkExtraBundle\Configuration\Route;
use Symfony\Bundle\FrameworkBundle\Controller\Controller;
use Symfony\Component\HttpFoundation\Request;

class ReportController extends Controller
{
    /**
     * @param Request $request
     * @Route("/", name="index")
     * @return \Symfony\Component\HttpFoundation\Response
     */
    public function index(Request $request)
    {
        // Get all reports
        $reports = $this->getDoctrine()->getRepository(Report::class)->findAll();

        // Pass the reports to the index view
        return $this->render('report/index.html.twig', ['reports' => $reports]);
    }

    /**
     * @Route("/details/{id}", name="details")
     *
     * @param $id
     * @param Request $request
     * @return \Symfony\Component\HttpFoundation\Response
     */
    public function details($id, Request $request)
    {
        // Get the report
        $report = $this->getDoctrine()->getRepository(Report::class)->find($id);
        if ($report == null){
            return $this->redirect("/");
        }

        // Pass the report to the details view
        return $this->render('report/details.html.twig', ['report' => $report]);
    }

    /**
     * @param Request $request
     * @Route("/create", name="create")
     * @return \Symfony\Component\HttpFoundation\Response
     */
    public function create(Request $request)
    {
        // Create a new report object
        $report = new Report();

        // Pass the empty report object to the form
        $form = $this->createForm(ReportType::class, $report);
        $form->handleRequest($request);

        // If the form is submitted, save the report in the database and redirect user to home page
        if ($form->isSubmitted()) {
            if ($form->isValid()) {
                $em = $this->getDoctrine()->getManager();
                $em->persist($report);
                $em->flush();

                return $this->redirectToRoute('index');
            }
        }

        // If there is an error, show the create form again
        return $this->render('report/create.html.twig',
            ["report" => $report, "form" => $form->createView()]
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
        // Get the report to be deleted
        $report = $this->getDoctrine()->getRepository(Report::class)->find($id);
        if ($report == null){
            return $this->redirect("/");
        }

        // Pass the report to the delete form
        $form = $this->createForm(ReportType::class, $report);
        $form->handleRequest($request);

        // If the form is submitted, remove the report from the database and redirect user to home page
        if ($form->isSubmitted()) {
            if ($form->isValid()) {
                $em = $this->getDoctrine()->getManager();
                $em->remove($report);
                $em->flush();

                return $this->redirectToRoute('index');
            }
        }

        // If there is an error, show the delete form again
        return $this->render('report/delete.html.twig',
            ["report" => $report, "form" => $form->createView()]
        );
    }
}
