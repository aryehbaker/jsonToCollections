package com.company.Restaurant;

import java.util.ArrayList;
import java.util.List;

public class Restaurants {


        private List<Restaurant> restaurants = new ArrayList<Restaurant>();

        public List<Restaurant> getRestaurants() {
            return restaurants;
        }

        public void setRestaurants(List<Restaurant> restaurants) {
            this.restaurants = restaurants;
        }

        @Override
        public String toString() {
            return "RestaurantsList restaurants=" + restaurants
                    + "]";
        }

}
