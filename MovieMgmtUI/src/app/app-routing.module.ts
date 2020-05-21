import { NgModule, Component } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { pathToFileURL } from 'url';
import { AddMovieComponent } from './add-movie/add-movie.component';
import { GetMovieComponent } from './get-movie/get-movie.component';
import { MoviedetailsComponent } from './moviedetails/moviedetails.component';


const routes: Routes = [
  {
  path:'add-movie',
  component:AddMovieComponent
  },
  {
    path:'get-movie',
    component:GetMovieComponent
  },
  {
    path:'moivedetails',
    component:MoviedetailsComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
