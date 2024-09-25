# Les Exos !

## Exercice 1: 

- Créer un nouveau Angular 
- Créer un composant "counter"
- Intégrer le composant dans app
- Le composant counter doit afficher un compteur, 
- qui commence à 0
- qui est rouge si le nombre est impair, et vert si le nombre est pair
- qui s'incrémente ou se décrémente grâce à 2 boutons


## Exercice 2:

- Créer un nouveau composant "Séries";
- Créer la route du composant + la route du composant counter.
- Créer la barre de navigation
- Afficher ces 2 composants.
- Dans séries, créer une liste de séries en dur.
- Afficher la liste
- Afficher un message si il n'y a rien dans la liste
- Ajouter un bouton de suppression sur chaque élément de liste.

## Exercice 3

- Créer un pipe personnalisé qui prend en paramétre un tableau, et une string 'order' ( 'asc', 'desc');
- Utiliser ce pipe sur le tableau des séries pour le trier par alphabétique/
- Ajouter 2 boutons pour modifier l'ordre du tableau (asc, desc).

## Exercice 4

- Créer un composant Librairie, et sa route
- Dans ce composant, afficher une liste de livres
  - title
  - author
  - isRead
- Quand les livres sont lus, on affiche un emoji pouce vers le haut à côté du titre 
- + titre souligné,
- sinon un emoji pouce vers le bas. ( Utiliser un pipe pour l'emoji )
- Ajouter un bouton pour marquer un livre comme lu / pas lu.

## Exercice 5

Dans le composant librairie, créer une formulaire pour créer un livre.
Le titre et l'auteur.trice sont obligatoire.
Par défaut, la valeur de isRead est false.
Ajouter le nouveau livre à la liste précédente.


## Exercice 6

Créer un nouveau composant et sa route
- Dans ce composant, créer un formulaire réactif pour créer un pokemon.
  - nom
  - description
  - liste de types ( eau, psy, feu, ect... )
  - liste d'attaques
    - nom
    - description
    - dégats
  - zone 
    - nom (string)
    - region (string)


## Exercice 7

Reprendre les pokemons ( cf correction )
Transformer les cartes en composant pour afficher les pokemons.


## Exercice 8

Créer un bouton dans le pokemon-card permettant de supprimer un pokemon.
- Le bouton doit envoyer un événement au parent.
- Le parent doit récupérer cet événement pour supprimer le pokemon de la liste

## Exercice 9

Créer un PokedexService
- Contient un tableau de pokemons
- Deux méthodes pour ajouter et supprimer du tableau
- Une méthode pour vérifier si un pokemon est déjà dans le pokedex

- Dans PokemonCard, ajouter un bouton pour ajouter au pokédex
- Dans une page Pokedex afficher la liste des pokemons du pokedex


## Exercice 10

 - Créer un nouveau projet de site de e-commerce
- Gérer mes marchandises : ajouter, supprimer, voir dans un tableau d'administration
- Page d'accueil avec une entête, un footer, une grille de mes marchandises.
- On peut ajouter des marchandises dans un panier.
- On peut voir le panier

Bonus : 
- Sur la page d'accueil, on peut trier les marchandises par prix
- On peut rechercher une marchandise par son nom avec une barre de recherche
- On ajoute un système de stocks sur les marchandises : si il n'y en a plus en stocks;
  -> elles s'affichent en grisée, et on ne peut pas l'ajouter au panier.

Bonus Bonus
- Installer json-server@0.17.4 et json-server-auth
- Utiliser json-server-auth pour permettre une connexion / Inscription
- Sécuriser la page admin, accessible uniquement sur connexion
- Renvoyer le JWT à chaque requêtes si il existe
- Permettre la modification d'une brouette via une page update
- Utiliser json-server@0.17.4 pour stocker / récupérer les brouettes.



## Exercice 11

Reprendre le pokedex : 
- Afficher dans la barre de navigation, à côté du lien vers le pokedex, 
le nombre de pokemons qu'il y a dedans.

## Exercice 12

Créer un nouveau composant, ChuckNorris
-> Utiliser l'api Chuck Norris dans un service fact pour afficher une fact en random.
- Le composant doit recevoir une string
Ajouter un bouton pour recharger la blague
- https://api.chucknorris.io/



## Exercice 13

Créer une application de quiz
Avec au choix un back end en Java / API existante 

