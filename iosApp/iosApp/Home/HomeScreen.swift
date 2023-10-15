//
//  HomeScreen.swift
//  iosApp
//
//  Created by Alain Paluku on 09/10/2023.
//  Copyright © 2023 orgName. All rights reserved.
//

import SwiftUI

struct HomeScreen: View {
    @StateObject var viewModel: IOSHomeViewModel = IOSHomeViewModel()
    
    var body: some View {
        
        NavigationStack {
            ZStack {
                
                if viewModel.state.error != nil {
                    Text(viewModel.state.error!)
                } else {
                    if viewModel.state.isLoading {
                        ProgressView()
                            .animation(.easeInOut, value: true)
                            .padding(10)
                            .cornerRadius(100)
                            .progressViewStyle(CircularProgressViewStyle(tint: .white))
                    } else {
                        VStack {
                            List {
                                
                                ForEach (viewModel.state.users, id: \.username) { item in
                                    Text(item.username)
                                }
                            }
                            .listStyle(.plain)
                            .buttonStyle(.plain)
                        }
                    }
                }
            }
            .navigationTitle("NetApp Fetch")
            .onAppear {
                viewModel.startObserving()
            }
            .refreshable {
                viewModel.onEvent(event: .OnFetch())
            }
            .onDisappear {
                viewModel.dispose()
            }
            
        }
        
    }
}

struct HomeScreen_Previews: PreviewProvider {
    static var previews: some View {
        HomeScreen()
    }
}
