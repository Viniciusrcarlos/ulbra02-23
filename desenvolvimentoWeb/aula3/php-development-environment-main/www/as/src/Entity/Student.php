<?php

namespace App\Entity;

use App\Repository\StudentRepository;
use Doctrine\Common\Collections\ArrayCollection;
use Doctrine\Common\Collections\Collection;
use Doctrine\ORM\Mapping as ORM;
use JsonSerializable;

#[ORM\Entity(repositoryClass: StudentRepository::class)]
class Student implements JsonSerializable
{
    #[ORM\Id]
    #[ORM\GeneratedValue]
    #[ORM\Column]
    private ?int $id = null;

    #[ORM\Column(length: 150)]
    private ?string $name = null;

    #[ORM\Column(length: 1000)]
    private ?string $description = null;

    #[ORM\Column]
    private ?int $age = null;

    #[ORM\ManyToOne(targetEntity: self::class, inversedBy: 'students')]
    private ?self $School = null;

    #[ORM\OneToMany(mappedBy: 'School', targetEntity: self::class)]
    private Collection $students;

    public function __construct()
    {
        $this->students = new ArrayCollection();
    }

    public function getId(): ?int
    {
        return $this->id;
    }

    public function getName(): ?string
    {
        return $this->name;
    }

    public function setName(string $name): static
    {
        $this->name = $name;

        return $this;
    }

    public function getDescription(): ?string
    {
        return $this->description;
    }

    public function setDescription(string $description): static
    {
        $this->description = $description;

        return $this;
    }

    public function getAge(): ?int
    {
        return $this->age;
    }

    public function setAge(int $age): static
    {
        $this->age = $age;

        return $this;
    }

    public function getSchool(): ?self
    {
        return $this->School;
    }

    public function setSchool(?self $School): static
    {
        $this->School = $School;

        return $this;
    }

    /**
     * @return Collection<int, self>
     */
    public function getStudents(): Collection
    {
        return $this->students;
    }

    public function addStudent(self $student): static
    {
        if (!$this->students->contains($student)) {
            $this->students->add($student);
            $student->setSchool($this);
        }

        return $this;
    }

    public function removeStudent(self $student): static
    {
        if ($this->students->removeElement($student)) {
            // set the owning side to null (unless already changed)
            if ($student->getSchool() === $this) {
                $student->setSchool(null);
            }
        }

        return $this;
    }

    public function jsonSerialize()
    {
        return [
            "id" => $this->getId(),
            "name" => $this->getName(),
            "age" => $this->getAge(),
            "description" => $this->getDescription(),
            "school" => $this->getSchool()
        ];
    }
}
