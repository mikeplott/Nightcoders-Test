(ns nightcoders.test
  (:require [reagent.core :as r]))

(def clicks (r/atom 0))
(def show-form? (r/atom true))

(defn form []
    [:form
     {:class "form-group" :id "login"}
     [:div
      {:class "form-group"}    
      [:label {:for "uName"} "Username"]
      [:input {:type "text" :class "form-control" :id "uName"}]]
     [:div
      {:class "form-group"}
      [:label {:for "pWord"} "Password"]
      [:input {:type "password" :class "form-control" :id "pWord"}]]
     [:div
      {:class "form-group"}
      [:button {:on-click (fn [event]
                            (.preventDefault event)
                            (reset! show-form? false)) 
                :class "btn btn-primary"} 
       "Submit"]]])

(defn login []
  [:nav {:class "navbar navbar-inverse navbar-fixed-top"}
   [:div {:class "container-fluid"}
    [:div {:class "navbar-header"}
     [:a {:class "navbar-brand" :href "#"} "TABLES FOR DAYS!"]]
    [:div {:class "navbar-collapse collapse"}
     [:ul {:class "nav navbar-nav"}
      [:li
       [:a {:href "#"} "Dashboard"]]
      [:li 
       [:a {:href "#"} "Settings"]]
      [:li
       [:a {:href "#"} "Profile"]]
      [:li
       [:a {:href "#"} "Help"]]]
     [:form {:class "navbar-form navbar-right"}
      [:input {:type "text" :class "form-control" :placeholder "Search..."}]]]]]
  [:h1 "COMO ESTAS BITCHES!"])

(defn content []
  (if @show-form?
    [form]
    [login]))

(r/render-component [content] (.querySelector js/document "#content"))

