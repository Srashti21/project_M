import { Component, OnInit } from '@angular/core';
import { movieService } from '../service/movieService';
import { Movies } from '../model/movie';

@Component({
  selector: 'app-add-movie',
  templateUrl: './add-movie.component.html',
  styleUrls: ['./add-movie.component.css']
})
export class AddMovieComponent implements OnInit {

  service:movieService;

  constructor(service:movieService) {
    this.service=service;
   }

  ngOnInit(): void {
  }

added:Movies=null;

addMovie(form:any){
let details=form.value;
let movieId=details.movieId;
let movieName=details.movieName;
let movieGenre=details.movieGenre;
let movieDirector=details.movieDirector;
let movieLength=details.movieLength;
let movieLanguage=details.movieLanguage;
let movieReleaseDate=details.movieReleaseDate;
 this.added=new Movies(movieId,movieName,movieGenre,movieDirector,movieLength,movieReleaseDate,movieLanguage);
 this.added.movieId=movieId;
 this.added.movieName=movieName;
 this.added.movieGenre=movieGenre;
 this.added.movieDirector=movieDirector;
 this.added.movieLength=movieLength;
 this.added.movieLanguage=movieLanguage;
 this.added.movieReleaseDate=movieReleaseDate;

 let result=this.service.addMovie(this.added);
 result.subscribe((movie:Movies)=>{
   this.added=movie;
 },
 err=>{
  console.log("err="+err);
  } );
  form.reset();
 
}

}