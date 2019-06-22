import {BrowserModule, } from '@angular/platform-browser';
import {NgModule, } from '@angular/core';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {NgbModule, NgbDateAdapter, NgbDateNativeAdapter, NgbDateParserFormatter} from '@ng-bootstrap/ng-bootstrap';
import {HttpClientModule} from '@angular/common/http';
import {AngularFontAwesomeModule} from 'angular-font-awesome';
import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {AddTodoPopupComponent} from './add-todo-popup/add-todo-popup.component';
import {ConfirmPopupComponent} from './confirm-popup/confirm-popup.component';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {ToastrModule} from 'ngx-toastr';
import {ReadmorePopupComponent} from './readmore-popup/readmore-popup.component';

@NgModule({
    declarations: [
        AppComponent,
        AddTodoPopupComponent,
        ConfirmPopupComponent,
        ReadmorePopupComponent
    ],
    imports: [
        BrowserModule,
        AppRoutingModule,
        NgbModule,
        FormsModule,
        ReactiveFormsModule,
        HttpClientModule,
        AngularFontAwesomeModule,
        BrowserAnimationsModule, // required animations module
        ToastrModule.forRoot()
    ],
    entryComponents: [
        AddTodoPopupComponent
    ],
    providers: [{provide: NgbDateAdapter, useClass: NgbDateNativeAdapter}],
    bootstrap: [AppComponent]
})
export class AppModule {}
