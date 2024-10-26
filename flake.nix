{
  description = "A game that I made for my programming class, in java :(";

  inputs = {
    nixpkgs.url = "github:NixOS/nixpkgs/nixpkgs-unstable";
    flake-utils.url = "github:numtide/flake-utils";
  };

  outputs = {
    self,
    flake-utils,
    nixpkgs,
  }:
    flake-utils.lib.eachDefaultSystem (
      system: let
        pkgs = (import nixpkgs) {
          inherit system;
        };

	javaPkgs = with pkgs; [
	  gradle
	  jdk17
	];
      in {
        devShell = pkgs.mkShell {
          packages = with pkgs; [
	    nushell
	  ] ++ javaPkgs;

	  shellHook = "nu && exit";
	};
      }
    );
}


