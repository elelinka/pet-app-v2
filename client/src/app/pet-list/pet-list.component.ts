import { PetService } from '../shared/pet/pet.service';
import {Component, OnInit} from "@angular/core";
import { GiphyService } from '../shared/giphy/giphy.service';

@Component({
  selector: 'app-pet-list',
  templateUrl: './pet-list.component.html',
  styleUrls: ['./pet-list.component.css']
})
export class PetListComponent implements OnInit {
  pets: Array<any>;

  constructor(private petService: PetService, private giphyService: GiphyService) { }

  ngOnInit() {
    this.petService.getAll().subscribe(data => {
      this.pets = data;
      for (const pet of this.pets) {
        this.giphyService.get(pet.name).subscribe(url => pet.giphyUrl = url);
      }
    });
  }
}
