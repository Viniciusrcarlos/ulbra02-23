<?php

namespace App\Controller;

use App\Entity\Director;
use App\Entity\Movie;
use App\Repository\directorRepository;
use Doctrine\ORM\EntityManagerInterface;
use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;
use Symfony\Component\HttpFoundation\JsonResponse;
use Symfony\Component\HttpFoundation\Request;
use Symfony\Component\Routing\Annotation\Route;

#[Route('/director')]
class DirectorController extends AbstractController
{
    #[Route('/', name: 'new_director', methods:["POST"])]
    public function new(EntityManagerInterface $em, Request $request)
    {
        $parametros = json_decode($request->getContent() ,true);
        $director = new Director();
        $director->setName($parametros["name"]);
        $director->setBirthday(\DateTime::createFromFormat(\DateTime::ATOM, $parametros["birthday"]));
        $em->persist($director);
        $em->flush();
        return $this->json(["Saved"]);
    }
    #[Route('/', name: 'get_all_director')]
    public function index(directorRepository $directorRepository): JsonResponse
    {

        $director = $directorRepository->findAll();

        return $this->json($director);
    }

    #[Route('/{id}', name: 'delete_director', methods:["DELETE"])]
    public function delete(EntityManagerInterface $em, int $id): JsonResponse
    {
        $directorRepository = $em->getRepository(director::class);
        $director = $directorRepository->find($id);
        if (is_null($director)){
            return $this->json("director already removed .");    
        }
        $em->remove($director);
        $em->flush();
        return $this->json("Removed");
    }

    #[Route('/{id}', name: 'edit_director', methods:["PUT"])]
    public function edit(EntityManagerInterface $em, int $id, Request $request): JsonResponse
    {
        $parametros = json_decode($request->getContent() ,true);
        $directorRepository = $em->getRepository(director::class);
        $director = $directorRepository->find($id);
        $director->setDescription($parametros["description"]);
        $director->setTitle($parametros["title"]);
        $em->persist($director);
        $em->flush();
        return $this->json("Up to date .");
    }
}