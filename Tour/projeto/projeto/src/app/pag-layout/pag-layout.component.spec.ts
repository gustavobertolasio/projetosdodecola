import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PagLayoutComponent } from './pag-layout.component';
import { RouterTestingModule } from '@angular/router/testing';

describe('PagLayoutComponent', () => {
  let component: PagLayoutComponent;
  let fixture: ComponentFixture<PagLayoutComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PagLayoutComponent ],
      imports:[RouterTestingModule]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PagLayoutComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
