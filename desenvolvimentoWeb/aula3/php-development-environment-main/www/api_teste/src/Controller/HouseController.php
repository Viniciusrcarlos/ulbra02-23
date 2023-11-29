<?php

namespace App\Controller;

use App\Entity\House;
use App\Entity\Person;
use App\Repository\HouseRepository;
use Doctrine\ORM\EntityManagerInterface;
use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;
use Symfony\Component\HttpFoundation\JsonResponse;
use Symfony\Component\HttpFoundation\Request;
use Symfony\Component\Routing\Annotation\Route;

#[Route('/house')]
class HouseController extends AbstractController
{
    #[Route('/', name: 'new_house', methods:["POST"])]
    public function new(EntityManagerInterface $em, Request $request)
    {
        $parametros = json_decode($request->getContent() ,true);
        $house = new House();
        $house->setNumber($parametros["number"]);
        $em->persist($house);
        $em->flush();
        return $this->json(["Saved"]);
    }

    #[Route('/', name: 'get_all_house', methods:["GET"])]
    public function index(HouseRepository $houseRepository): JsonResponse
    {

        $house = $houseRepository->findAll();

        return $this->json($house);
    }

    #[Route('/{id}', name: 'delete_house', methods:["DELETE"])]
    public function delete(EntityManagerInterface $em, int $id): JsonResponse
    {
        $houseRepository = $em->getRepository(House::class);
        $house = $houseRepository->find($id);
        if (is_null($house)){
            return $this->json("house already removed .");    
        }
        $em->remove($house);
        $em->flush();
        return $this->json("Removed");
    }

    #[Route('/{id}', name: 'edit_house', methods:["PUT"])]
    public function edit(EntityManagerInterface $em, int $id, Request $request): JsonResponse
    {
        $parametros = json_decode($request->getContent(),true);
        $houseRepository = $em->getRepository(House::class);
        $house = $houseRepository->find($id);
        $house->setNumber($parametros["number"]);
        $em->persist($house);
        $em->flush();
        return $this->json("Updated");
    }
}