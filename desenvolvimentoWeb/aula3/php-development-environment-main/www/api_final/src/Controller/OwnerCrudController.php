<?php

namespace App\Controller;

use App\Entity\Owner;
use App\Form\OwnerType;
use App\Repository\OwnerRepository;
use Doctrine\ORM\EntityManagerInterface;
use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;
use Symfony\Component\HttpFoundation\Request;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\Routing\Annotation\Route;

#[Route('/owner/crud')]
class OwnerCrudController extends AbstractController
{
    #[Route('/', name: 'app_owner_crud_index', methods: ['GET'])]
    public function index(OwnerRepository $ownerRepository): Response
    {
        return $this->render('owner_crud/index.html.twig', [
            'owners' => $ownerRepository->findAll(),
        ]);
    }

    #[Route('/new', name: 'app_owner_crud_new', methods: ['GET', 'POST'])]
    public function new(Request $request, EntityManagerInterface $entityManager): Response
    {
        $owner = new Owner();
        $form = $this->createForm(OwnerType::class, $owner);
        $form->handleRequest($request);

        if ($form->isSubmitted() && $form->isValid()) {
            $entityManager->persist($owner);
            $entityManager->flush();

            return $this->redirectToRoute('app_owner_crud_index', [], Response::HTTP_SEE_OTHER);
        }

        return $this->render('owner_crud/new.html.twig', [
            'owner' => $owner,
            'form' => $form,
        ]);
    }

    #[Route('/{id}', name: 'app_owner_crud_show', methods: ['GET'])]
    public function show(Owner $owner): Response
    {
        return $this->render('owner_crud/show.html.twig', [
            'owner' => $owner,
        ]);
    }

    #[Route('/{id}/edit', name: 'app_owner_crud_edit', methods: ['GET', 'POST'])]
    public function edit(Request $request, Owner $owner, EntityManagerInterface $entityManager): Response
    {
        $form = $this->createForm(OwnerType::class, $owner);
        $form->handleRequest($request);

        if ($form->isSubmitted() && $form->isValid()) {
            $entityManager->flush();

            return $this->redirectToRoute('app_owner_crud_index', [], Response::HTTP_SEE_OTHER);
        }

        return $this->render('owner_crud/edit.html.twig', [
            'owner' => $owner,
            'form' => $form,
        ]);
    }

    #[Route('/{id}', name: 'app_owner_crud_delete', methods: ['POST'])]
    public function delete(Request $request, Owner $owner, EntityManagerInterface $entityManager): Response
    {
        if ($this->isCsrfTokenValid('delete'.$owner->getId(), $request->request->get('_token'))) {
            $entityManager->remove($owner);
            $entityManager->flush();
        }

        return $this->redirectToRoute('app_owner_crud_index', [], Response::HTTP_SEE_OTHER);
    }
}
