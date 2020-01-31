import { Component, OnInit } from '@angular/core';
import { hero } from '../hero';
import { HEROES } from '../mock-heroes';

@Component({
  selector: 'heroes',
  templateUrl: './heroes.component.html',
  styleUrls: ['./heroes.component.css']
})
export class HeroesComponent implements OnInit {
  rero: hero = {
    id: 1,
    name: "Windstorm"
  };

  heroes:hero[] = HEROES;
  constructor() { }

  ngOnInit() {
  }
  selected:hero;
  onSelect(Hero:hero)
  {
    this.selected=Hero;

  }

}
