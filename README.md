# puffin
A Kotlin library featuring
* pure algorithms and the idea of small interfaces as taught by Robert Sedgewick (Princeton University) 
* command-query separation and uniform access as taught by Bertrand Meyer (ETH Zurich)

Puffin includes Queue, Stack, and Bag factories

Tested with Spock

---

Member of the **farallons** collection of libraries

---

Use Bazel

- Install Bazel (instructions here for Ubuntu 19.10)

      curl https://bazel.build/bazel-release.pub.gpg >> bazel-release.pub.gpg
      sudo apt-key add bazel-release.pub.gpg
      echo "deb [arch=amd64] https://storage.googleapis.com/bazel-apt stable jdk1.8" | sudo tee /etc/apt/sources.list.d/bazel.list
      sudo apt update && sudo apt install bazel
      sudo apt update && sudo apt full-upgrade
      
- Go to the project root folder
       
- Build 

      bazel build ...

- Test

      bazel test ...
      
- In the bazel-bin folder, look for _puffin.jar_