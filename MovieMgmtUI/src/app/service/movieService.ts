import { Injectable } from '@angular/core';
import { Observable, observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Movies } from '../model/movie'
  @Injectable()
  export class movieService{
    client:HttpClient ;
    constructor(client:HttpClient ){
    this.client=client;
    }

    baseMovieUrl="http://localhost:8086/movies";

    addMovie(movie:Movies):Observable<Movies>{
        let url = this.baseMovieUrl+"/add";
        let observable : Observable<Movies> = this.client.post<Movies>(url,movie);
        return observable;
    }
    
    fetchAllMovies():Observable<Movies[]>{
      let url = this.baseMovieUrl;
      let observable : Observable<Movies[]>=this.client.get<Movies[]>(url);
      return observable;
    }
    
    getMovie(movieId:number):Observable<Movies>{
      let url = this.baseMovieUrl+"/get/"+movieId;
      let result:Observable<Movies> = this.client.get<Movies>(url);
      return result;
    }

    
    
    deleteMovie(movieId:number){
      let url = this.baseMovieUrl+"/delete/"+movieId;
      let result:Observable<boolean> = this.client.delete<boolean>(url);
      return result;
    }
    
    
    
    

  }