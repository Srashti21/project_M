import { Component, OnInit } from '@angular/core';
import { Movie } from '../model/movie';
import { movieService} from '../service/movieService'
import { Observable } from 'rxjs';
@Component({
  selector: 'get-movie',
  templateUrl: './get-movie.component.html',
  styleUrls: ['./get-movie.component.css']
})
export class GetMovieComponent implements OnInit {

service:movieService;
movie:Movie=null;
foundStatus="";

  constructor(service:movieService) { 
    this.service=service;
  }

  ngOnInit(): void {
  }

findMovieById(form:any):void{
  this.foundStatus="";
  let details=form.value;
  let movieId=details.movieId;
  let fetched:Observable<Movie>=this.service.getMovie(movieId);
  fetched.subscribe(
    movie=>{
      this.movie=movie;
      this.foundStatus="found";
      console.log("found movie="+movie.movieName);
    },
    err=>{
      this.foundStatus="notfound";
     console.log("err while fetching movies="+err.error);
    }
  );
}
  
}
