<?php

declare(strict_types=1);

namespace DoctrineMigrations;

use Doctrine\DBAL\Schema\Schema;
use Doctrine\Migrations\AbstractMigration;

/**
 * Auto-generated Migration: Please modify to your needs!
 */
final class Version20231206002131 extends AbstractMigration
{
    public function getDescription(): string
    {
        return '';
    }

    public function up(Schema $schema): void
    {
        // this up() migration is auto-generated, please modify it to your needs
        $this->addSql('ALTER TABLE student DROP CONSTRAINT fk_b723af33eab5deb');
        $this->addSql('DROP INDEX idx_b723af33eab5deb');
        $this->addSql('ALTER TABLE student RENAME COLUMN many_to_one_id TO school_id');
        $this->addSql('ALTER TABLE student ADD CONSTRAINT FK_B723AF33C32A47EE FOREIGN KEY (school_id) REFERENCES student (id) NOT DEFERRABLE INITIALLY IMMEDIATE');
        $this->addSql('CREATE INDEX IDX_B723AF33C32A47EE ON student (school_id)');
    }

    public function down(Schema $schema): void
    {
        // this down() migration is auto-generated, please modify it to your needs
        $this->addSql('CREATE SCHEMA public');
        $this->addSql('ALTER TABLE student DROP CONSTRAINT FK_B723AF33C32A47EE');
        $this->addSql('DROP INDEX IDX_B723AF33C32A47EE');
        $this->addSql('ALTER TABLE student RENAME COLUMN school_id TO many_to_one_id');
        $this->addSql('ALTER TABLE student ADD CONSTRAINT fk_b723af33eab5deb FOREIGN KEY (many_to_one_id) REFERENCES school (id) NOT DEFERRABLE INITIALLY IMMEDIATE');
        $this->addSql('CREATE INDEX idx_b723af33eab5deb ON student (many_to_one_id)');
    }
}
