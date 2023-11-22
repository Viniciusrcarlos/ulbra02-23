<?php

namespace App\Controller;

use App\Entity\Car;
use App\Entity\Owner;
use App\Form\CarType;
use App\Repository\CarRepository;
use Doctrine\ORM\EntityManagerInterface;
use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;
use Symfony\Component\HttpFoundation\JsonResponse;
use Symfony\Component\HttpFoundation\Request;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\Routing\Annotation\Route;

#[Route('/car')]
class CarController extends AbstractController
{
    #[Route('/', name: 'new_car', methods: ["POST"])]
    public function new(EntityManagerInterface $em, Request $request): JsonResponse
    {
        $ownerRepository = $em->getRepository(Owner::class);
        $parametros = json_decode($request->getContent(), true);
        $car = new Car();
        $owner = $ownerRepository->find($parametros["owner"]);
        $car->setModel($parametros["model"]);
        $car->setPlate($parametros["plate"]);
        $car->setOwner($owner);

        $em->persist($car);
        $em->flush();

        return $this->json("save");
    }

    #[Route('/', name: 'get_all_cars', methods: ["GET"])]
    public function index(CarRepository $carRepository): JsonResponse
    {

        $car = $carRepository->findAll();

        return $this->json($car);
    }

    #[Route('/{id}', name: 'delete_car', methods:["DELETE"])]
    public function delete(EntityManagerInterface $em, int $id): JsonResponse
    {
        $carRepository = $em->getRepository(car::class);
        $car = $carRepository->find($id);
        if (is_null($car)){
            return $this->json("car already removed .");    
        }
        $em->remove($car);
        $em->flush();
        return $this->json("Removed");
    }

    #[Route('/{id}', name: 'edit_owner', methods:["PUT"])]
    public function edit(EntityManagerInterface $em, int $id, Request $request): JsonResponse
    {
        $parametros = json_decode($request->getContent(),true);
        $carRepository = $em->getRepository(Car::class);
        $car  = $carRepository->find($id);
        $car->setModel($parametros["model"]);
        $car->setPlate($parametros["plate"]);
        $em->persist($car);
        $em->flush();
        return $this->json("Updated");
    }

}
