import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ModelDriveComponent } from './model-drive.component';

describe('ModelDriveComponent', () => {
  let component: ModelDriveComponent;
  let fixture: ComponentFixture<ModelDriveComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ModelDriveComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ModelDriveComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
