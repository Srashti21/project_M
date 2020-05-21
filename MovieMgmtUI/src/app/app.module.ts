import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {FormsModule} from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AddMovieComponent } from './add-movie/add-movie.component';
import { GetMovieComponent } from './get-movie/get-movie.component';
import { MoviedetailsComponent } from './moviedetails/moviedetails.component';
import { movieService } from './service/movieService';

@NgModule({
  declarations: [
    AppComponent,
    AddMovieComponent,
    GetMovieComponent,
    MoviedetailsComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    AppRoutingModule,
    HttpClientModule
  ],
  providers: [movieService],
  bootstrap: [AppComponent]
})
export class AppModule { }
