<?php

namespace App\Controller;

use App\Entity\Movie;
use App\Repository\MovieRepository;
use Doctrine\ORM\EntityManagerInterface;
use Doctrine\ORM\Mapping\Entity;
use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;
use Symfony\Component\HttpFoundation\JsonResponse;
use Symfony\Component\Routing\Annotation\Route;

#[Route('/movie')]
class MovieController extends AbstractController
{
    #[Route('/', name: 'get_all_movies')]
    public function index(MovieRepository $movieRepository): JsonResponse
    {
        $movies = $movieRepository->findAll();
        return $this->json($movies);
    }

    #[Route('/new', name: 'new_movie')]
    public function new(EntityManagerInterface $em) 
    {
        $movie = new Movie();
        $movie->setDescription("Qualquer coisa...");
        $movie->setTitle("Qualquer coisa...");
        $em->persist($movie);
        $em->flush();

        return $this->json(["Savage"]);

    }
}
