import { NgModule, Component } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { pathToFileURL } from 'url';
import { AddMovieComponent } from './add-movie/add-movie.component';
import { GetMovieComponent } from './get-movie/get-movie.component';
import { MoviedetailsComponent } from './moviedetails/moviedetails.component';
import { WelcomeComponent } from './welcome/welcome.component';


const routes: Routes = [
  {
  path:'add-movie',
  component:AddMovieComponent
  },
  {
   path:'welcome',
   component:WelcomeComponent
  },
  {
    path:'get-movie',
    component:GetMovieComponent
  },
  {
    path:'movies-detail',
    component:MoviedetailsComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
