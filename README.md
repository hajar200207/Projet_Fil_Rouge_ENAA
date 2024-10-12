# Projet_Fil_Rouge_ENAA
Gestion des Conférences Scientifiques
Introduction
Les conférences scientifiques jouent un rôle primordial dans la diffusion des connaissances. Ce projet vise à développer une plateforme web permettant la gestion complète des conférences, depuis la soumission des articles jusqu'à la gestion des participants. Le site simplifie également la publication des articles, la gestion des emplacements, et facilite la communication entre les participants et les organisateurs.

Fonctionnalités Clés
Gestion des Conférences :
Création, modification et suppression de conférences.
Gestion des emplacements et des salles.
Soumission et Évaluation des Articles :
Soumission en ligne des articles par les auteurs.
Système d'évaluation et d'acceptation des articles par des examinateurs.
Gestion des Participants :
Inscription des participants aux conférences.
Envoi d'invitations et gestion des conférenciers, sponsors et invités.
Publication :
Publication des articles acceptés, des présentations et des programmes des conférences.
Contexte du Projet
Ce projet est réalisé dans le cadre du programme de formation à l'École Numérique Ahmed Al-Hansali (ENAA) et vise à mettre en pratique les compétences acquises tout au long du parcours. Il permet de démontrer la maîtrise de plusieurs aspects du développement web, incluant la conception, le développement backend et frontend, la sécurité, ainsi que les tests.

Technologies Utilisées
Backend :
Spring Boot : Framework Java pour la gestion de la logique métier et l'API REST.
Spring Security : Gestion de l'authentification et de la sécurité des données.
JUnit & Mockito : Tests unitaires et tests d'intégration.
Frontend :
Angular : Framework JavaScript pour la gestion de l'interface utilisateur.
Angular Material : Composants UI pour une meilleure expérience utilisateur.
Base de données :
PostgreSQL ou MySQL : Gestion des données des utilisateurs, articles, conférences, etc.
Outils de Développement :
Docker : Conteneurisation de l'application pour faciliter le déploiement.
Jira/Trello : Gestion des tâches du projet.
Figma : Maquettage des interfaces utilisateur.
Installation
Prérequis
Java 11+
Node.js et npm
Docker
PostgreSQL/MySQL
Angular CLI
Étapes d'installation
Clonez le dépôt :

git clone https://github.com/username/repo.git
cd repo
Backend (Spring Boot) :

Configurez les paramètres de la base de données dans application.properties.
Démarrez l'application Spring Boot :

./mvnw spring-boot:run
Frontend (Angular) :

Installez les dépendances :

cd frontend
npm install
Démarrez l'application Angular :

ng serve
Accédez à l'application sur http://localhost:4200.

Docker (Optionnel)
Vous pouvez également exécuter l'application à l'aide de Docker :
bash
Copy code
docker-compose up --build
Contributions
Les contributions sont les bienvenues ! Suivez ces étapes pour contribuer :

Fork le dépôt.
Créez une branche (git checkout -b feature/ma-fonctionnalite).
Apportez vos modifications et commit (git commit -m 'Ajout de ma fonctionnalité').
Poussez votre branche (git push origin feature/ma-fonctionnalite).
Ouvrez une Pull Request.
Auteur
Hajar - Étudiant Full Stack Developer
Licence
Ce projet est sous licence MIT.
