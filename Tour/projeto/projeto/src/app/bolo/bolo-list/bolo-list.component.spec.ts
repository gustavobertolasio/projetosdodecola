import { async, ComponentFixture, TestBed, tick, fakeAsync } from '@angular/core/testing';
import { FormsModule } from '@angular/forms';
import { BoloListComponent } from './bolo-list.component';

import { BoloStoreService } from '../bolo-store.service';
describe('BoloListComponent', () => {
  let component: BoloListComponent;
  let fixture: ComponentFixture<BoloListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ BoloListComponent ],
      imports:[FormsModule]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(BoloListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  it('should start enabled', () => {
    const compiled = fixture.debugElement.nativeElement as HTMLElement;
    const button = compiled.querySelector('button') as HTMLButtonElement;
    const txt = compiled.querySelector('input[type=text]') as HTMLInputElement;

    expect(button.disabled).toBeFalsy();
    expect(txt.disabled).toBeFalsy();
  });

  it('should Add', fakeAsync(() => {
    const compiled = fixture.debugElement.nativeElement as HTMLElement;
    const button = compiled.querySelector('button') as HTMLButtonElement;
    const txt = compiled.querySelector('input[type=text]') as HTMLInputElement;

    txt.value = 'NovoValor';
    txt.dispatchEvent(new Event('input'));
    fixture.detectChanges();
    tick();
    button.click();
    fixture.detectChanges();
    tick();
    const listaLi = compiled.querySelectorAll('li').length;
    expect(listaLi).toEqual(4);

  }));

  it('should disable', async () => {
    const compiled = fixture.debugElement.nativeElement as HTMLElement;
    const checkbox = compiled.querySelector('input[type=checkbox]') as HTMLInputElement;
    checkbox.click();
    fixture.detectChanges();
    fixture.whenStable().then(() => {
      const button = compiled.querySelector('button') as HTMLButtonElement;
      const txt = compiled.querySelector('input[type=text]') as HTMLInputElement;
      const h3 = compiled.querySelector('h3') as HTMLElement;

      expect(button.disabled).toBeTruthy();
      expect(txt.disabled).toBeTruthy();
      expect(h3).not.toBeNull();
    });
  });

});
