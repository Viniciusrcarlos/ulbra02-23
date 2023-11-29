<?php

namespace App\Controller;

use App\Entity\Person;
use App\Entity\House;
use App\Repository\PersonRepository;
use Doctrine\ORM\EntityManagerInterface;
use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;
use Symfony\Component\HttpFoundation\JsonResponse;
use Symfony\Component\HttpFoundation\Request;
use Symfony\Component\Routing\Annotation\Route;

#[Route('/person')]
class PersonController extends AbstractController
{
    #[Route('/', name: 'new_person', methods:["POST"])]
    public function new(EntityManagerInterface $em, Request $request)
    {
        $houseRepository = $em->getRepository(House::class);
        $parametros = json_decode($request->getContent() ,true);
        $person = new Person();
        $house = $houseRepository->find($parametros["house"]);
        $person->setName($parametros["name"]);
        $person->setNickname($parametros["nickname"]);
        $person->setAge($parametros["age"]);
        $person->setHouse($house);
        $em->persist($person);
        $em->flush();
        return $this->json(["Saved"]);
    }

    #[Route('/', name: 'get_all_person', methods:["GET"])]
    public function index(PersonRepository $personRepository): JsonResponse
    {

        $person = $personRepository->findAll();

        return $this->json($person);
    }

    #[Route('/{id}', name: 'delete_person', methods:["DELETE"])]
    public function delete(EntityManagerInterface $em, int $id): JsonResponse
    {
        $personRepository = $em->getRepository(Person::class);
        $person = $personRepository->find($id);
        if (is_null($person)){
            return $this->json("person already removed .");    
        }
        $em->remove($person);
        $em->flush();
        return $this->json("Removed");
    }

    #[Route('/{id}', name: 'edit_person', methods:["PUT"])]
    public function edit(EntityManagerInterface $em, int $id, Request $request): JsonResponse
    {
        $houseRepository = $em->getRepository(House::class);
        $parametros = json_decode($request->getContent(),true);
        $personRepository = $em->getRepository(Person::class);
        $person  = $personRepository->find($id);
        $house = $houseRepository->find($parametros["house"]);
        $person->setName($parametros["name"]);
        $person->setNickname($parametros["nickname"]);
        $person->setAge($parametros["age"]);
        $person->setHouse($house);
        $em->persist($person);
        $em->flush();
        return $this->json("Updated");
    }
}