<?php

namespace App\Controller;

use App\Entity\Car;
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
        $parametros = json_decode($request->getContent(), true);
        $car = new Car();
        $car->setModel($parametros["model"]);
        $car->setPlate($parametros["plate"]);
        //$car->setOwner($parametros["owner"]);

        $em->persist($car);
        $em->flush();

        return $this->json("save");
    }
}
