import { Injectable } from '@angular/core';
import { Observable, observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Movie } from '../model/movie'
  @Injectable()
  export class movieService{
    client:HttpClient ;
    constructor(client:HttpClient ){
    this.client=client;
    }

    baseMovieUrl="http://localhost:8086/movies";

    addMovie(movie:Movie):Observable<Movie>{
      let text=JSON.stringify(movie);
      console.log("text="+text);
        let url = this.baseMovieUrl+"/add";
        let observable : Observable<Movie> = this.client.post<Movie>(url,movie);
        return observable;
    }
    
    fetchAllMovies():Observable<Movie[]>{
      let url = this.baseMovieUrl;
      let observable : Observable<Movie[]>=this.client.get<Movie[]>(url);
      return observable;
    }
    
    getMovie(movieId:number):Observable<Movie>{
      let url = this.baseMovieUrl+"/get/"+movieId;
      let result:Observable<Movie> = this.client.get<Movie>(url);
      return result;
    }

    
    
    deleteMovie(movieId:number){
      let url = this.baseMovieUrl+"/delete/"+movieId;
      let result:Observable<string> = this.client.delete(url,{responseType:'text'});
      return result;
    }
    
    
    
    

  }