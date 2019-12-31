# farallons
A Kotlin library featuring
* pure algorithms and the idea of small interfaces as taught by Robert Sedgwick (Princeton University) 
* command-query separation and uniform access as taught by Bertrand Meyer (ETH Zurich)

---

To build and test, use Bazel

- Install Bazel

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