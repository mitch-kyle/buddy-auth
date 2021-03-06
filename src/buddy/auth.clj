;; Copyright (c) 2013-2014 Andrey Antukh <niwi@niwi.be>
;;
;; Licensed under the Apache License, Version 2.0 (the "License")
;; you may not use this file except in compliance with the License.
;; You may obtain a copy of the License at
;;
;;     http://www.apache.org/licenses/LICENSE-2.0
;;
;; Unless required by applicable law or agreed to in writing, software
;; distributed under the License is distributed on an "AS IS" BASIS,
;; WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
;; See the License for the specific language governing permissions and
;; limitations under the License.

(ns buddy.auth
  "Authorization and Authentication primitives for
  ring based applications."
  (:require [buddy.auth.protocols :as proto]))

(defn authenticated?
  "Return `true` if the `request` is an
  authenticated request.

  This function checks the `:identity` key
  in the request."
  [request]
  (boolean (:identity request)))

(defn throw-unauthorized
  "Throws a unauthorized exception.

  Used as fast skip exception based
  authorization primitive."
  ([] (throw-unauthorized {}))
  ([errordata]
   (throw (ex-info "Unauthorized." {::type ::unauthorized
                                    ::payload errordata}))))
