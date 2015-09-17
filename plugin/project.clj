(defproject lein-servlet "0.4.2"
  :description "Leiningen plugin to work with servlet based webapps"
  :url "https://github.com/kumarshantanu/lein-servlet"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :min-lein-version "2.0.0"
  :dependencies []
  :warn-on-reflection true
  :eval-in :leiningen
  :eval-in-leiningen true
  :plugins [[org.apache.maven.wagon/wagon-ssh-external "2.6"]]
  :repositories [["releases" "scp://10.1.0.197:/home/gvickers/repository"]]
  :deploy-repositories [["releases" {:url "scp://10.1.0.197:/home/gvickers/repository"
                                     :signing {:gpg-key "373F9636"}}]])

(cemerick.pomegranate.aether/register-wagon-factory!
 "scp" #(let [c (resolve 'org.apache.maven.wagon.providers.ssh.external.ScpExternalWagon)]
          (clojure.lang.Reflector/invokeConstructor c (into-array []))))
