                <%
                if (session.getAttribute("login") != null)
                   {
                %>
            <div class="w3-content w3-justify w3-text-grey w3-padding-64" id="planos">
                <!-- Grid for pricing tables -->
                <h3 class="w3-padding-16 w3-text-light-grey">My Price</h3>
                <div class="w3-row-padding" style="margin:0 -16px">
                    <div class="w3-half w3-margin-bottom">
                        <ul class="w3-ul w3-white w3-center w3-opacity w3-hover-opacity-off">
                            <li class="w3-dark-grey w3-xlarge w3-padding-32">Basic</li>
                            <li class="w3-padding-16">Web Design</li>
                            <li class="w3-padding-16">Photography</li>
                            <li class="w3-padding-16">5GB Storage</li>
                            <li class="w3-padding-16">Mail Support</li>
                            <li class="w3-padding-16">
                                <h2>$ 10</h2>
                                <span class="w3-opacity">per month</span>
                            </li>
                            <li class="w3-light-grey w3-padding-24">
                                <button class="w3-button w3-white w3-padding-large w3-hover-black">Sign Up</button>
                            </li>
                        </ul>
                    </div>

                    <div class="w3-half">
                        <ul class="w3-ul w3-white w3-center w3-opacity w3-hover-opacity-off">
                            <li class="w3-dark-grey w3-xlarge w3-padding-32">Pro</li>
                            <li class="w3-padding-16">Web Design</li>
                            <li class="w3-padding-16">Photography</li>
                            <li class="w3-padding-16">50GB Storage</li>
                            <li class="w3-padding-16">Endless Support</li>
                            <li class="w3-padding-16">
                                <h2>$ 25</h2>
                                <span class="w3-opacity">per month</span>
                            </li>
                            <li class="w3-light-grey w3-padding-24">
                                <button class="w3-button w3-white w3-padding-large w3-hover-black">Sign Up</button>
                            </li>
                        </ul>
                    </div>
                    <!-- End Grid/Pricing tables -->
                </div>
            </div>
                <%
                    }
                %>