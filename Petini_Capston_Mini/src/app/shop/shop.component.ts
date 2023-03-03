import { Component, OnInit } from '@angular/core';
import { ImageService } from '../services/image.service';
import { ShopService } from '../services/shop.service';

@Component({
  selector: 'app-shop',
  templateUrl: './shop.component.html',
  styleUrls: ['./shop.component.scss']
})
export class ShopComponent implements OnInit{
  values : any[]=[];
  value:any;
  ngOnInit(): void {
    this.http.getItems().subscribe(async  (data) =>{
      // this.value = data;
      // for(this.i of this.value ){
      //   console.log(this.i.homestayImages[0].url)
      // }
      console.log("data" , data);
      for(this.value of data){


        var imgUrl = await this.image.getImage('items/' + this.value.imageUrl)
        console.log("imaURL:" , imgUrl);
        this.values.push({imgURL:imgUrl, name:this.value.name, price:this.value.price })
        console.log("values:", this.values);
      }

    })
  }
  constructor(private image: ImageService,private http: ShopService){

  }

}
