(ns resources.resources)

(def user-resource
  {:resource :user
   :table :users

   :view
   {:index {:path :user
            :type :table
            :fields
            [{:path :first_name
              :type :text}

             {:path :last_name
              :label "Last Name"
              :type :text}

             {:path :email
              :label "Email"
              :type :text}]}}})
