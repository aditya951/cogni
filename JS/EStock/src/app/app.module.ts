import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CompanyComponent } from './company/company.component';
import { CreateComponent } from './create/create.component';
import { NewCompanyComponent } from './new-company/new-company.component';
import { StockComponent } from './stock/stock.component';
import { IndividualComponent } from './individual/individual.component';

@NgModule({
  declarations: [
    AppComponent,
    CompanyComponent,
    CreateComponent,
    NewCompanyComponent,
    StockComponent,
    IndividualComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
