<?php

namespace App\Controller;

use App\Entity\School;
use App\Entity\Student;
use App\Repository\SchoolRepository;
use Doctrine\ORM\EntityManagerInterface;
use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;
use Symfony\Component\HttpFoundation\JsonResponse;
use Symfony\Component\HttpFoundation\Request;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\Routing\Annotation\Route;

#[Route('/school')]
class SchoolController extends AbstractController
{
    #[Route('/', name: 'new_school', methods: ["POST"])]
    public function new(EntityManagerInterface $em, Request $request): JsonResponse
    {
        $parametros = json_decode($request->getContent(), true);
        $school = new School();
        $school->setName($parametros["name"]);

        $em->persist($school);
        $em->flush();

        return $this->json("save");
    }

    #[Route('/', name: 'get_all_school', methods: ["GET"])]
    public function index(SchoolRepository $schoolRepository): JsonResponse
    {

        $school = $schoolRepository->findAll();

        return $this->json($school);
    }

    #[Route('/{id}', name: 'delete_school', methods:["DELETE"])]
    public function delete(EntityManagerInterface $em, int $id): JsonResponse
    {
        $schoolRepository = $em->getRepository(school::class);
        $school = $schoolRepository->find($id);
        if (is_null($school)){
            return $this->json("school already removed .");    
        }
        $em->remove($school);
        $em->flush();
        return $this->json("Removed");
    }

    #[Route('/{id}', name: 'edit_school', methods:["PUT"])]
    public function edit(EntityManagerInterface $em, int $id, Request $request): JsonResponse
    {
        $parametros = json_decode($request->getContent(),true);
        $schoolRepository = $em->getRepository(School::class);
        $school  = $schoolRepository->find($id);
        $school->setName($parametros["name"]);
        $em->persist($school);
        $em->flush();
        return $this->json("Updated");
    }

}
