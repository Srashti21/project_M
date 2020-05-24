import { Component, OnInit } from '@angular/core';
import { movieService } from '../service/movieService';
import { Movie } from '../model/movie';

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

added:Movie=null;

resultMsg="";
created="";

addMovie(form:any){
this.resultMsg=""; 

let details=form.value;
let english=details.english;
let hindi=details.hindi;
if(!english && !hindi){
  return;
}
console.log("english="+english+" hindi="+hindi);
let languages=[];
if(english==true){
languages.push("english");
}
if(hindi==true){
  languages.push("hindi");
}

let movieName=details.movieName;
let movieGenre=details.movieGenre;
let movieDirector=details.movieDirector;
let movieLength=details.movieLength;
let movieLanguage=details.movieLanguage;
let movieReleaseDate=details.movieReleaseDate;
 let movie=new Movie();
 movie.movieName=movieName;
 movie.movieGenre=movieGenre;
 movie.movieDirector=movieDirector;
 movie.movieLength=movieLength;
 movie.languages=movieLanguage;
 movie.movieReleaseDate=movieReleaseDate;
movie.languages=languages;
 let result=this.service.addMovie(movie);
 result.subscribe((movie:Movie)=>{
   this.added=movie;
   this.created="created";
   this.resultMsg="Movie added, id generated="+movie.movieId;
   form.reset();
 },
 err=>{
  this.created="notcreated"; 
  console.log("err="+err.message);
 this.resultMsg=err.message; 
} );
  
}

}