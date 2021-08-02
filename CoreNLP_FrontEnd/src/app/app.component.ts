import { Component, OnInit } from '@angular/core';
import { HttpClient,HttpParams } from '@angular/common/http';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  ngOnInit(): void {
  }

  constructor(private http: HttpClient) { }
  title = 'CoreNLP_FrontEnd';
   a: any;

  generatepdf(title:String) {
    if (title == ""){
      alert("The program does not accept empty text. ");
      return;
    }
    let params = new HttpParams();
    params = params.append('uid', title.toString());


     this.http.get('http://localhost:8080/SpringRestExample/getnouns',  {params: params})
     .subscribe(data1 => {
       console.log(data1);
        var filename="output.txt";
        var fileText = "Text : " + data1[6] + "\r\n\n\n" + "Number of Sentences  :  "+data1[1]+"\r\n" +"Number of Words  :  "+data1[0]+"\r\n"+"Number of Nouns  :  "+data1[2]+"\r\n"+ "Number of Adjectives  :  "+data1[7]+"\r\n" + "Sentences :  "+data1[4]+"\r\n"+ "Words :  "+data1[3]+"\r\n" + "Nouns :  "+data1[5]+"\r\n" + "Adjectives :  "+data1[8]+"\r\n" ;      
        var blob = new Blob([fileText], {type: 'text/plain'}),
            e    = document.createEvent('MouseEvents'),
            a    = document.createElement('a')
// FOR IE:

  if (window.navigator && window.navigator.msSaveOrOpenBlob) {
      window.navigator.msSaveOrOpenBlob(blob, filename);
  }
  else{
      var e = document.createEvent('MouseEvents'),
          a = document.createElement('a');

      a.download = filename;
      a.href = window.URL.createObjectURL(blob);
      a.dataset.downloadurl = ['text/plain', a.download, a.href].join(':');
      e.initEvent('click', true, false);
      a.dispatchEvent(e);
  
}





     });
  }

}
