<?php

namespace App\Controller;

use App\Entity\Student;
use App\Entity\School;
use App\Repository\StudentRepository;
use Doctrine\ORM\EntityManagerInterface;
use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;
use Symfony\Component\HttpFoundation\JsonResponse;
use Symfony\Component\HttpFoundation\Request;
use Symfony\Component\Routing\Annotation\Route;

#[Route('/student')]
class StudentController extends AbstractController
{
    #[Route('/', name: 'new_student', methods:["POST"])]
    public function new(EntityManagerInterface $em, Request $request)
    {
        
        $parametros = json_decode($request->getContent() ,true);
        //$schoolRepository = $em->getRepository(School::class);
        //$school = $schoolRepository->find($parametros["school"]);
        $student = new Student();
        $student->setName($parametros["name"]);
        $student->setAge($parametros["age"]);
        $student->setDescription($parametros["description"]); 
        //$student->setSchool($school);
        $em->persist($student);
        $em->flush();
        return $this->json(["Saved"]);
    }

    #[Route('/', name: 'get_all_student', methods:["GET"])]
    public function index(StudentRepository $studentRepository): JsonResponse
    {

        $student = $studentRepository->findAll();

        return $this->json($student);
    }

    #[Route('/{id}', name: 'delete_student', methods:["DELETE"])]
    public function delete(EntityManagerInterface $em, int $id): JsonResponse
    {
        $studentRepository = $em->getRepository(Student::class);
        $student = $studentRepository->find($id);
        if (is_null($student)){
            return $this->json("house already removed .");    
        }
        $em->remove($student);
        $em->flush();
        return $this->json("Removed");
    }

    #[Route('/{id}', name: 'edit_student', methods:["PUT"])]
    public function edit(EntityManagerInterface $em, int $id, Request $request): JsonResponse
    {
        $parametros = json_decode($request->getContent() ,true);
        //$SchoolRepository = $em->getRepository(School::class);
        $student = new Student();
        //$school = $SchoolRepository->find($parametros["school"]);
        $student->setName($parametros["name"]);
        $student->setAge($parametros["age"]);
        $student->setDescription($parametros["description"]); 
        //$student->setSchool($school);
        $em->persist($student);
        $em->flush();
        return $this->json(["Saved"]);
    }
}