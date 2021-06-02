//
//  LaunchesScreen.swift
//  launchitios
//
//  Created by Roman Korostenskyi on 02.06.2021.
//  Copyright © 2021 orgName. All rights reserved.
//

import SwiftUI
import shared

struct LaunchesScreen: View {
    
    @ObservedObject var viewModel: LaunchesViewModel
    
    var body: some View {
        List(viewModel.launches, id: \.id) { launch in
            LaunchView(launch: launch)
        }.onAppear {
            viewModel.loadData()
        }
    }
}

struct LaunchView: View {
    
    let launch: Launch
    
    var body: some View {
        VStack {
            HStack {
                Text("\(launch.flightNumber)")
                Spacer()
            }
            HStack {
                Text(launch.name)
                Spacer()
                if let isSuccessful = launch.isSuccessful?.boolValue {
                    if isSuccessful {
                        Text("Success")
                    } else {
                        Text("Failure")
                    }
                } else if launch.isUpcoming {
                    Text("Upcoming...")
                }
            }
        }
        .padding()
        .clipShape(RoundedRectangle(cornerRadius: 25.0))
    }
}
