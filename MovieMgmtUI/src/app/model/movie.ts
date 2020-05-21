export class Movies{
    movieId : number;
	 movieName : String;
	 movieGenre : String;
	 movieDirector : String;
	 movieLength : Number;
	 movieReleaseDate : Date;
	 movieLanguage: String[];


constructor(movieId : number, movieName : String,movieGenre : String,movieDirector : String,movieLength : number,movieReleaseDate : Date,movieLanguage: String[]){
this.movieId=movieId;
this.movieName=movieName;
this.movieGenre=movieGenre;
this.movieDirector=movieDirector;
this.movieLanguage=movieLanguage;
this.movieLength=movieLength;
this.movieReleaseDate=movieReleaseDate;
}

}