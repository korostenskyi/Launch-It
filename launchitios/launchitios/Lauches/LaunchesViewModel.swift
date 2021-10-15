//
//  LaunchesViewModel.swift
//  launchitios
//
//  Created by Roman Korostenskyi on 02.06.2021.
//  Copyright © 2021 orgName. All rights reserved.
//

import shared

class LaunchesViewModel : ObservableObject {
    
    @Published var launches = [Launch]()
    
    private var launchesInteractor: LaunchesInteractor
    
    init(launchesInteractor: LaunchesInteractor) {
        self.launchesInteractor = launchesInteractor
    }
    
    func loadData() {
        launchesInteractor.retrieveAllLaunches { [weak self] result, error in
            if let result = result {
                self?.launches.append(contentsOf: result)
            } else if let error = error {
                print(error)
            }
        }
    }
}
