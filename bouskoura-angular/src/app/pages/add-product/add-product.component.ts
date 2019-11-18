import {Component, OnInit} from '@angular/core';
import {AuthService} from '../../service/auth.service';

@Component({
  selector: 'app-add-product',
  templateUrl: './add-product.component.html',
  styleUrls: ['./add-product.component.css']
})
export class AddProductComponent implements OnInit {

  constructor(private auth: AuthService) {
  }

  ngOnInit() {
  }

  logout() {
    this.auth.logout();
  }
}
