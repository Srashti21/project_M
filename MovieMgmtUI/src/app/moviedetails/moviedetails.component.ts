import { Component, OnInit } from '@angular/core';
import { Movies } from '../model/movie';
import { movieService } from '../service/movieService';
import { Observable, ObservedValueOf } from 'rxjs';

@Component({
  selector: 'app-moviedetails',
  templateUrl: './moviedetails.component.html',
  styleUrls: ['./moviedetails.component.css']
})
export class MoviedetailsComponent implements OnInit {

movies:Movies[]=[];

service:movieService;

orderByField:string=null;

  constructor(service:movieService) { 
    this.service=service;
    
    let observable:Observable<Movies[]>=this.service.fetchAllMovies();
    observable.subscribe(
      movie=>{
        this.movies=movie;
        console.log("inside success callback ="+this.movies.length);
      },
      err=>console.log(err)
    );
  
  }

  ngOnInit(): void {
  }

  removeMovieById(movieId:number){
    let result:Observable<boolean>=this.service.deleteMovie(movieId);
result.subscribe(movie=>{
  this.removeMovieById(movieId);
},err=>{
  console.log("error in deleting movie = "+err);
})
  }
 
  removeMovie(movieId:number){
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
