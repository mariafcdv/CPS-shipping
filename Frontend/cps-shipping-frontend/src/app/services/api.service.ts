import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs';

export interface Region {
  regionId: number;
  name: string;
}

export interface Country {
  countryId: number;
  name: string;
  rate: number;
  regionId: number;
  regionName: string;
}

export interface ClientType {
  clientTypeId: number;
  name: string;
  discount: number;
}

export interface QuoteRequest {
  weight: number;
  width: number;
  height: number;
  length: number;
  destinationCountryId: number;
  originCountryId?: number;
  clientTypeId?: number | null;
}

export interface QuoteResponse {
  rate: number;
  discountPercent: number;
  baseCost: number;
  volumeCost: number;
  discountAmount: number;
  total: number;
}

@Injectable({ providedIn: 'root' })
export class ApiService {
  private baseUrl = 'http://localhost:8080/api';

  constructor(private http: HttpClient) {}

  getRegions(): Observable<Region[]> {
    return this.http.get<Region[]>(`${this.baseUrl}/regions`);
  }

  getCountries(regionId?: number): Observable<Country[]> {
    let params = new HttpParams();
    if (regionId != null) params = params.set('regionId', regionId);
    return this.http.get<Country[]>(`${this.baseUrl}/countries`, { params });
  }

  getClientTypes(): Observable<ClientType[]> {
    return this.http.get<ClientType[]>(`${this.baseUrl}/client-types`);
  }

  quote(body: QuoteRequest): Observable<QuoteResponse> {
    return this.http.post<QuoteResponse>(`${this.baseUrl}/quote`, body);
  }
}