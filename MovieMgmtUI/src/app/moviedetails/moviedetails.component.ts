import { Component, OnInit } from '@angular/core';
import { Movie } from '../model/movie';
import { movieService } from '../service/movieService';
import { Observable, ObservedValueOf } from 'rxjs';

@Component({
  selector: 'movies-detail',
  templateUrl: './moviedetails.component.html',
  styleUrls: ['./moviedetails.component.css']
})
export class MoviedetailsComponent implements OnInit {

movies:Movie[]=[];

service:movieService;


  constructor(service:movieService) { 
    this.service=service;
    
  }

  ngOnInit(): void {
  
    let observable:Observable<Movie[]>=this.service.fetchAllMovies();
    observable.subscribe(
      movies=>{
        this.movies=movies;
        for(let movie of movies){
          console.log(movie.languages);
        }
        console.log("inside success callback ="+this.movies.length);
      },
      err=>console.log(err.error)
    );
  }

  removeMovieById(movieId:number){
    let result:Observable<string>=this.service.deleteMovie(movieId);
    result.subscribe(movie=>{
  this.removeLocalMovie(movieId);
},err=>{
  console.log("error in deleting movie = "+err.message);
})
  }


 
  removeLocalMovie(movieId:number){
    let foundIndex=-1;
    for(let i=0;i<this.movies.length;i++){
      let movie=this.movies[i];
      if(movie.movieId==movieId){
        foundIndex=i;
        break;
      }
    }
    if(foundIndex<0){
      return;
    }
    this.movies.splice(foundIndex,1);
  }
}
