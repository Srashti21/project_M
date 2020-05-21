import { Component, OnInit } from '@angular/core';
import { Movies } from '../model/movie';
import { movieService} from '../service/movieService'
import { Observable } from 'rxjs';
@Component({
  selector: 'app-get-movie',
  templateUrl: './get-movie.component.html',
  styleUrls: ['./get-movie.component.css']
})
export class GetMovieComponent implements OnInit {

service:movieService;
foundMovie:Movies=null;
foundStatus=null;

  constructor(service:movieService) { 
    this.service=service;
  }

  ngOnInit(): void {
  }

findMovieById(form:any):void{
  let details=form.value;
  let movieId=details.movieId;
  let fetched:Observable<Movies>=this.service.getMovie(movieId);
  fetched.subscribe(
    movie=>{
      this.foundMovie=movie;
      this.foundStatus="Found";
    },
    err=>{
      this.foundStatus="notfound";
     console.log("err while fetching movies="+err);
    }
  );
}
  
}
