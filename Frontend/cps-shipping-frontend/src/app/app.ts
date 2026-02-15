import { Component, OnInit, ChangeDetectorRef } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

import {
  ApiService,
  Region,
  Country,
  ClientType,
  QuoteResponse
} from './services/api.service';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class App implements OnInit {
  statusMsg = '';
  loading = false;
  regions: Region[] = [];
  countries: Country[] = [];
  clientTypes: ClientType[] = [];

  selectedRegionId: number | null = null;
  selectedCountryId: number | null = null;
  selectedClientTypeId: number | null = null;

  weight: number | null = null;
  width: number | null = null;
  height: number | null = null;
  length: number | null = null;

  result: QuoteResponse | null = null;
  errorMsg: string | null = null;

  constructor(private api: ApiService, private cdr: ChangeDetectorRef) {}

  ngOnInit(): void {
    this.api.getRegions().subscribe(r => (this.regions = r));
    this.api.getClientTypes().subscribe(ct => (this.clientTypes = ct));
  }

  onRegionChange(): void {
    this.selectedCountryId = null;
    this.countries = [];
    this.result = null;
    this.errorMsg = null;

    if (this.selectedRegionId != null) {
      this.api.getCountries(this.selectedRegionId).subscribe(c => (this.countries = c));
    }
  }

  quote(): void {
  this.loading = true;
  this.result = null;
  this.errorMsg = null;

  if (
    this.selectedCountryId == null ||
    this.weight == null ||
    this.width == null ||
    this.height == null ||
    this.length == null
  ) {
    this.loading = false;
    this.errorMsg = 'Completa el país destino y todas las medidas.';
    return;
  }

  this.api
    .quote({
      destinationCountryId: this.selectedCountryId,
      clientTypeId: this.selectedClientTypeId,
      weight: this.weight,
      width: this.width,
      height: this.height,
      length: this.length
    })
    .subscribe({
      next: (res) => {
        console.log('¡Respuesta recibida!', res);
        this.result = res;
        this.loading = false;
        this.cdr.detectChanges();
      },
      error: (err) => {
        this.errorMsg = err?.error?.error ?? 'Ocurrió un error al cotizar.';
        this.loading = false;
        this.cdr.detectChanges(); 
      }
    });
  }
}