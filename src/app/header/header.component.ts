import { Component, OnInit } from '@angular/core';
import { ThiscartService } from '../services/thiscart.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.scss']
})
export class HeaderComponent implements OnInit {

  public totalitem :number=0;
  constructor(private cartser:ThiscartService) { }

  ngOnInit(): void {
    this.cartser.getproducts()
    .subscribe(res=>{
      this.totalitem=res.length;
    })
  }

}
