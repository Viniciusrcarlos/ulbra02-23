<?php

namespace App\Controller;

use App\Entity\Owner;
use App\Entity\Car;
use App\Repository\OwnerRepository;
use Doctrine\ORM\EntityManagerInterface;
use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;
use Symfony\Component\HttpFoundation\JsonResponse;
use Symfony\Component\HttpFoundation\Request;
use Symfony\Component\Routing\Annotation\Route;

#[Route('/owner')]
class OwnerController extends AbstractController
{
    #[Route('/', name: 'new_owner', methods:["POST"])]
    public function new(EntityManagerInterface $em, Request $request)
    {
        $parametros = json_decode($request->getContent() ,true);
        $owner = new Owner();
        $owner->setName($parametros["name"]);
        $owner->setNickname($parametros["nickname"]);
        $em->persist($owner);
        $em->flush();
        return $this->json(["Saved"]);
    }

    #[Route('/', name: 'get_all_director')]
    public function index(OwnerRepository $ownerRepository): JsonResponse
    {

        $owner = $ownerRepository->findAll();

        return $this->json($owner);
    }

    #[Route('/{id}', name: 'delete_owner', methods:["DELETE"])]
    public function delete(EntityManagerInterface $em, int $id): JsonResponse
    {
        $ownerRepository = $em->getRepository(Owner::class);
        $owner = $ownerRepository->find($id);
        if (is_null($owner)){
            return $this->json("owner already removed .");    
        }
        $em->remove($owner);
        $em->flush();
        return $this->json("Removed");
    }

    #[Route('/{id}', name: 'edit_owner', methods:["PUT"])]
    public function edit(EntityManagerInterface $em, int $id, Request $request): JsonResponse
    {
        $parametros = json_decode($request->getContent(),true);
        $ownerRepository = $em->getRepository(Owner::class);
        $owner  = $ownerRepository->find($id);
        $owner->setName($parametros["name"]);
        $owner->setNickname($parametros["nickname"]);
        $em->persist($owner);
        $em->flush();
        return $this->json("Updated");
    }
}