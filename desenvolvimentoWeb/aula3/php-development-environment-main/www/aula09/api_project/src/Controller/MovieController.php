<?php

namespace App\Controller;

use App\Entity\Director;
use App\Entity\Movie;
use App\Repository\MovieRepository;
use Doctrine\ORM\EntityManagerInterface;
use Doctrine\ORM\Mapping\Entity;
use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;
use Symfony\Component\HttpFoundation\JsonResponse;
use Symfony\Component\HttpFoundation\Request;
use Symfony\Component\Routing\Annotation\Route;

#[Route('/movie')]
class MovieController extends AbstractController
{
    #[Route('/', name: 'new_movie', methods: ["POST"])]
    public function new(EntityManagerInterface $em, Request $request) 
    {
        $directorRepository = $em->getRepository(Director::class);
        $parametros = json_decode($request->getContent(),true);
        $director = $directorRepository->find($parametros["director"]);
        $movie = new Movie();
        $movie->setDescription($parametros["description"]);
        $movie->setTitle($parametros["title"]);
        $movie->setDirector($director);
        $em->persist($movie);
        $em->flush();

        return $this->json(["Saved"]);

    }

    #[Route('/', name: 'get_all_movies')]
    public function index(MovieRepository $movieRepository): JsonResponse
    {
        $movies = $movieRepository->findAll();
        return $this->json($movies);
    }

    #[Route('/{id}', name: 'delete_movie', methods:["DELETE"])]
    public function delete(EntityManagerInterface $em, int $id): JsonResponse
    {
        $movieRepository = $em->getRepository(Movie::class);
        $movie  = $movieRepository->find($id);
        if (is_null($movie)){
            return $this->json("Movie already removed");
        }
        $em->remove($movie);
        $em->flush();
        return $this->json("Removed");
    }

    #[Route('/{id}', name: 'edit_movie', methods:["PUT"])]
    public function edit(EntityManagerInterface $em, int $id, Request $request): JsonResponse
    {
        $parametros = json_decode($request->getContent(),true);
        $movieRepository = $em->getRepository(Movie::class);
        $movie  = $movieRepository->find($id);
        $movie->setDescription($parametros["description"]);
        $movie->setTitle($parametros["title"]);
        $em->persist($movie);
        $em->flush();
        return $this->json("Updated");
    }
    
}
